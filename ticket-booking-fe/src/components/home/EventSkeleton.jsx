import React from "react";
import "./EventSkeleton.css";

export const EventSkeleton = ({ count = 6 }) => {
  return (
    <div className="event-skeleton-grid">
      {Array.from({ length: count }).map((_, i) => (
        <div key={i} className="event-skeleton-card">
          <div className="skeleton-media shimmer" />
          <div className="skeleton-body">
            <div className="skeleton-line short shimmer" />
            <div className="skeleton-line title shimmer" />
            <div className="skeleton-line medium shimmer" />
            <div className="skeleton-footer">
              <div className="skeleton-line price shimmer" />
              <div className="skeleton-btn shimmer" />
            </div>
          </div>
        </div>
      ))}
    </div>
  );
};
