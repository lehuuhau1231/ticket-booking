import React, { useState, useEffect, useRef } from "react";
import { ChevronDown, MapPin, Search, X } from "lucide-react";
import { cityApi } from "../../api/cityApi";
import { cities as fallbackCities } from "../../data/cities";
import "./CitySelect.css";

export const CitySelect = ({ value, onChange, placeholder = "Tất cả địa điểm" }) => {
  const [isOpen, setIsOpen] = useState(false);
  const [searchTerm, setSearchTerm] = useState("");
  const [cityList, setCityList] = useState([]);
  const dropdownRef = useRef(null);

  useEffect(() => {
    let isMounted = true;
    const fetchCities = async () => {
      try {
        const response = await cityApi.getCities();
        const apiCities = response?.result;
        if (isMounted && Array.isArray(apiCities) && apiCities.length > 0) {
          setCityList(apiCities.map((c) => ({ value: c.code, label: c.name })));
          return;
        }
      } catch (err) {
        console.warn("Using fallback city list:", err);
      }
      if (isMounted) {
        setCityList(fallbackCities);
      }
    };

    fetchCities();
    return () => {
      isMounted = false;
    };
  }, []);

  // Handle click outside to close dropdown
  useEffect(() => {
    const handleClickOutside = (event) => {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        setIsOpen(false);
      }
    };

    if (isOpen) {
      document.addEventListener("mousedown", handleClickOutside);
    }
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, [isOpen]);

  const selectedCity = cityList.find((c) => c.value === value);

  const filteredCities = cityList.filter((city) =>
    city.label.toLowerCase().includes(searchTerm.toLowerCase().trim())
  );

  const handleSelect = (cityValue) => {
    if (onChange) {
      onChange(cityValue);
    }
    setIsOpen(false);
    setSearchTerm("");
  };

  const handleClear = (e) => {
    e.stopPropagation();
    if (onChange) {
      onChange("");
    }
    setIsOpen(false);
  };

  return (
    <div className="city-select-wrapper" ref={dropdownRef}>
      <button
        type="button"
        className={`city-select-trigger ${isOpen ? "active" : ""}`}
        onClick={() => setIsOpen((prev) => !prev)}
      >
        <MapPin size={18} className="city-icon" />
        <span className="city-label text-truncate">
          {selectedCity ? selectedCity.label : placeholder}
        </span>
        {value ? (
          <span
            className="clear-icon"
            onClick={handleClear}
            title="Bỏ chọn địa điểm"
          >
            <X size={15} />
          </span>
        ) : (
          <ChevronDown
            size={16}
            className={`chevron-icon ${isOpen ? "rotate" : ""}`}
          />
        )}
      </button>

      {isOpen && (
        <div className="city-select-dropdown">
          <div className="city-search-box">
            <Search size={15} className="city-search-icon" />
            <input
              type="text"
              className="city-search-input"
              placeholder="Tìm nhanh tỉnh/thành..."
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              autoFocus
            />
          </div>

          <div className="city-options-list">
            <div
              className={`city-option-item ${!value ? "selected" : ""}`}
              onClick={() => handleSelect("")}
            >
              <span>{placeholder}</span>
            </div>

            {filteredCities.length > 0 ? (
              filteredCities.map((city) => (
                <div
                  key={city.value}
                  className={`city-option-item ${
                    value === city.value ? "selected" : ""
                  }`}
                  onClick={() => handleSelect(city.value)}
                >
                  <span>{city.label}</span>
                </div>
              ))
            ) : (
              <div className="city-no-results">Không tìm thấy địa điểm</div>
            )}
          </div>
        </div>
      )}
    </div>
  );
};
