import React from "react";
import "./CategoryFilter.css";

const CATEGORIES = [
  { key: "ALL", label: "Tất cả" },
  { key: "MUSIC", label: "Âm nhạc" },
  { key: "STAGE", label: "Sân khấu" },
  { key: "MOVIE", label: "Điện ảnh" },
  { key: "SPORTS", label: "Thể thao" },
  { key: "WORKSHOP", label: "Hội thảo" },
];

export const CategoryFilter = ({ activeCategory, onSelectCategory }) => {
  return (
    <div className="category-filter-container">
      <div className="category-pills">
        {CATEGORIES.map((cat) => {
          const isActive =
            (activeCategory === cat.key) ||
            (!activeCategory && cat.key === "ALL");
          return (
            <button
              key={cat.key}
              type="button"
              className={`category-pill-btn ${isActive ? "active" : ""}`}
              onClick={() => onSelectCategory(cat.key)}
            >
              {cat.label}
            </button>
          );
        })}
      </div>
    </div>
  );
};
