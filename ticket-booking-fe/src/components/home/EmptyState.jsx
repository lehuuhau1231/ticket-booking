import React from "react";
import { SearchX, RotateCcw } from "lucide-react";
import "./EmptyState.css";

export const EmptyState = ({ onReset }) => {
  return (
    <div className="empty-state-container">
      <div className="empty-state-icon-box">
        <SearchX size={44} className="empty-state-icon" />
      </div>
      <h3 className="empty-state-title">Không tìm thấy sự kiện nào</h3>
      <p className="empty-state-desc">
        Rất tiếc, chúng tôi không tìm thấy sự kiện phù hợp với từ khóa hoặc bộ
        lọc bạn đã chọn. Vui lòng thử tìm với từ khóa khác hoặc xóa bộ lọc.
      </p>
      {onReset && (
        <button type="button" className="empty-state-reset-btn" onClick={onReset}>
          <RotateCcw size={16} />
          <span>Xem tất cả sự kiện</span>
        </button>
      )}
    </div>
  );
};
