import React, { useState, useEffect, useCallback } from "react";
import { Container } from "react-bootstrap";
import { SearchBar } from "../../components/home/SearchBar";
import { CategoryFilter } from "../../components/home/CategoryFilter";
import { EventCard } from "../../components/home/EventCard";
import { EventSkeleton } from "../../components/home/EventSkeleton";
import { EmptyState } from "../../components/home/EmptyState";
import { ServiceHighlights } from "../../components/home/ServiceHighlights";
import { eventApi } from "../../api/eventApi";
import { Sparkles, X } from "lucide-react";
import "./Home.css";

export const Home = () => {
  const [keyword, setKeyword] = useState("");
  const [city, setCity] = useState("");
  const [category, setCategory] = useState("ALL");
  const [page, setPage] = useState(0);

  const [events, setEvents] = useState([]);
  const [totalElements, setTotalElements] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [loading, setLoading] = useState(true);

  // Search execution trigger state
  const [searchParams, setSearchParams] = useState({
    keyword: "",
    city: "",
    category: "ALL",
    page: 0,
  });

  const fetchEvents = useCallback(async () => {
    setLoading(true);
    try {
      const response = await eventApi.getEvents({
        keyword: searchParams.keyword,
        city: searchParams.city,
        category: searchParams.category,
        page: searchParams.page,
        size: 8,
      });

      const pageData = response?.result;
      if (pageData && Array.isArray(pageData.content)) {
        setEvents(pageData.content);
        setTotalElements(pageData.totalElements || 0);
        setTotalPages(pageData.totalPages || 0);
      } else {
        setEvents([]);
        setTotalElements(0);
        setTotalPages(0);
      }
    } catch (error) {
      console.error("Error fetching events:", error);
      setEvents([]);
      setTotalElements(0);
      setTotalPages(0);
    } finally {
      setLoading(false);
    }
  }, [searchParams]);

  useEffect(() => {
    fetchEvents();
  }, [fetchEvents]);

  // When user clicks Search button in SearchBar
  const handleSearchSubmit = () => {
    setPage(0);
    setSearchParams({
      keyword,
      city,
      category,
      page: 0,
    });
  };

  // When category changes
  const handleCategorySelect = (newCategory) => {
    setCategory(newCategory);
    setPage(0);
    setSearchParams((prev) => ({
      ...prev,
      category: newCategory,
      page: 0,
    }));
  };

  // When city changes
  const handleCityChange = (newCity) => {
    setCity(newCity);
    setPage(0);
    setSearchParams((prev) => ({
      ...prev,
      city: newCity,
      page: 0,
    }));
  };

  // Reset all filters
  const handleResetFilters = () => {
    setKeyword("");
    setCity("");
    setCategory("ALL");
    setPage(0);
    setSearchParams({
      keyword: "",
      city: "",
      category: "ALL",
      page: 0,
    });
  };

  // Pagination navigation
  const handlePageChange = (newPage) => {
    setPage(newPage);
    setSearchParams((prev) => ({
      ...prev,
      page: newPage,
    }));
    window.scrollTo({ top: 380, behavior: "smooth" });
  };

  const hasActiveFilter =
    Boolean(searchParams.keyword) ||
    Boolean(searchParams.city) ||
    (searchParams.category && searchParams.category !== "ALL");

  return (
    <div className="home-page-wrapper">
      {/* 1. Hero & Search Section */}
      <section className="home-hero-section">
        <Container>
          <div className="hero-content">
            <div className="hero-badge">
              <Sparkles size={16} />
              <span>Đặt vé trực tuyến tiện lợi & an toàn</span>
            </div>
            <h1 className="hero-heading">
              Tìm kiếm sự kiện, hòa nhạc & giải trí yêu thích
            </h1>
            <p className="hero-subheading">
              Khám phá hàng ngàn đêm nhạc sống, phim chiếu rạp bom tấn, kịch sân
              khấu và giải đấu thể thao hấp dẫn trên toàn quốc.
            </p>

            <div className="hero-search-wrapper">
              <SearchBar
                keyword={keyword}
                onKeywordChange={setKeyword}
                city={city}
                onCityChange={handleCityChange}
                onSearch={handleSearchSubmit}
              />
            </div>
          </div>
        </Container>
      </section>

      {/* 2. Main Content Section */}
      <section className="home-events-section" id="events">
        <Container>
          {/* Category Filter Pills */}
          <CategoryFilter
            activeCategory={category}
            onSelectCategory={handleCategorySelect}
          />

          {/* Section Header & Active Filters Bar */}
          <div className="section-header-row">
            <div>
              <h2 className="section-title">
                {hasActiveFilter
                  ? `Kết quả tìm kiếm (${totalElements} sự kiện)`
                  : "Sự kiện sắp diễn ra"}
              </h2>
              <p className="section-subtitle">
                {hasActiveFilter
                  ? "Danh sách sự kiện khớp với bộ lọc của bạn"
                  : "Đừng bỏ lỡ các sự kiện nổi bật và được mong chờ nhất"}
              </p>
            </div>

            {hasActiveFilter && (
              <button
                type="button"
                className="clear-all-filter-btn"
                onClick={handleResetFilters}
              >
                <X size={15} />
                <span>Xóa bộ lọc</span>
              </button>
            )}
          </div>

          {/* Event Grid / Loading / Empty States */}
          {loading ? (
            <EventSkeleton count={8} />
          ) : events.length > 0 ? (
            <>
              <div className="events-grid">
                {events.map((event) => (
                  <EventCard key={event.id} event={event} />
                ))}
              </div>

              {/* Pagination */}
              {totalPages > 1 && (
                <div className="pagination-wrapper">
                  <button
                    type="button"
                    className="pagination-btn"
                    disabled={page === 0}
                    onClick={() => handlePageChange(page - 1)}
                  >
                    Trang trước
                  </button>

                  <div className="pagination-pages">
                    {Array.from({ length: totalPages }).map((_, idx) => (
                      <button
                        key={idx}
                        type="button"
                        className={`pagination-num-btn ${
                          idx === page ? "active" : ""
                        }`}
                        onClick={() => handlePageChange(idx)}
                      >
                        {idx + 1}
                      </button>
                    ))}
                  </div>

                  <button
                    type="button"
                    className="pagination-btn"
                    disabled={page >= totalPages - 1}
                    onClick={() => handlePageChange(page + 1)}
                  >
                    Trang sau
                  </button>
                </div>
              )}
            </>
          ) : (
            <EmptyState onReset={hasActiveFilter ? handleResetFilters : null} />
          )}

          {/* Service Highlights */}
          <ServiceHighlights />
        </Container>
      </section>
    </div>
  );
};
