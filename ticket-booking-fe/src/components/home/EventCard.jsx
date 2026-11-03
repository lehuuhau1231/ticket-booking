import React from "react";
import { Calendar, MapPin, Mic, Ticket } from "lucide-react";
import { useNavigate } from "react-router-dom";
import "./EventCard.css";

const CATEGORY_NAMES = {
  MUSIC: "Âm nhạc",
  STAGE: "Sân khấu",
  MOVIE: "Điện ảnh",
  SPORTS: "Thể thao",
  WORKSHOP: "Hội thảo",
};

export const EventCard = ({ event }) => {
  const navigate = useNavigate();

  const {
    id,
    title,
    posterUrl,
    category,
    city,
    locationName,
    startDate,
    minPrice,
    artists = [],
  } = event;

  const formatDate = (dateStr) => {
    if (!dateStr) return "Sắp diễn ra";
    try {
      const date = new Date(dateStr);
      const hours = String(date.getHours()).padStart(2, "0");
      const minutes = String(date.getMinutes()).padStart(2, "0");
      const day = String(date.getDate()).padStart(2, "0");
      const month = String(date.getMonth() + 1).padStart(2, "0");
      const year = date.getFullYear();
      return `${hours}:${minutes} - ${day}/${month}/${year}`;
    } catch {
      return dateStr;
    }
  };

  const formatPrice = (price) => {
    if (price === null || price === undefined) return "Đang cập nhật";
    return `Từ ${new Intl.NumberFormat("vi-VN").format(price)} đ`;
  };

  const handleCardClick = () => {
    navigate(`/events/${id}`);
  };

  return (
    <div className="event-card" onClick={handleCardClick}>
      <div className="event-card-media">
        <img
          src={
            posterUrl ||
            "https://images.unsplash.com/photo-1492684223066-81342ee5ff30?w=600&q=80"
          }
          alt={title}
          className="event-card-img"
          loading="lazy"
        />
        {category && (
          <span className="event-category-badge">
            {CATEGORY_NAMES[category] || category}
          </span>
        )}
      </div>

      <div className="event-card-body">
        <div className="event-date-row">
          <Calendar size={14} className="event-icon" />
          <span>{formatDate(startDate)}</span>
        </div>

        <h3 className="event-title" title={title}>
          {title}
        </h3>

        {artists && artists.length > 0 && (
          <div className="event-artists-row text-truncate">
            <Mic size={14} className="event-icon" />
            <span>{artists.join(", ")}</span>
          </div>
        )}

        <div className="event-location-row text-truncate">
          <MapPin size={14} className="event-icon" />
          <span>
            {locationName}
            {city?.name ? ` • ${city.name}` : ""}
          </span>
        </div>

        <div className="event-card-footer">
          <div className="event-price-wrapper">
            <span className="event-price">{formatPrice(minPrice)}</span>
          </div>

          <button
            type="button"
            className="event-buy-btn"
            onClick={(e) => {
              e.stopPropagation();
              handleCardClick();
            }}
          >
            <Ticket size={15} />
            <span>Mua vé</span>
          </button>
        </div>
      </div>
    </div>
  );
};
