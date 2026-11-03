import React from "react";
import { Search } from "lucide-react";
import { CitySelect } from "../citySelect/CitySelect";
import "./SearchBar.css";

export const SearchBar = ({
  keyword,
  onKeywordChange,
  city,
  onCityChange,
  onSearch,
}) => {
  const handleSubmit = (e) => {
    e.preventDefault();
    if (onSearch) {
      onSearch();
    }
  };

  const handleKeyDown = (e) => {
    if (e.key === "Enter") {
      handleSubmit(e);
    }
  };

  return (
    <form className="search-bar-container" onSubmit={handleSubmit}>
      <div className="search-input-group">
        <Search size={20} className="search-input-icon" />
        <input
          type="text"
          className="search-text-input"
          placeholder="Tìm kiếm sự kiện, nghệ sĩ biểu diễn..."
          value={keyword}
          onChange={(e) => onKeywordChange(e.target.value)}
          onKeyDown={handleKeyDown}
        />
      </div>

      <div className="search-city-group">
        <CitySelect
          value={city}
          onChange={onCityChange}
          placeholder="Tất cả địa điểm"
        />
      </div>

      <button type="submit" className="search-submit-btn">
        <Search size={18} className="btn-search-icon" />
        <span>Tìm kiếm</span>
      </button>
    </form>
  );
};
