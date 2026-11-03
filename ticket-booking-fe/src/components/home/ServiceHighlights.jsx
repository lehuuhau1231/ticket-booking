import React from "react";
import { ShieldCheck, Zap, Headphones } from "lucide-react";
import "./ServiceHighlights.css";

export const ServiceHighlights = () => {
  const highlights = [
    {
      icon: <ShieldCheck size={28} className="highlight-icon text-primary" />,
      title: "Vé chính hãng 100%",
      description: "Đảm bảo vé thật từ ban tổ chức, cam kết hoàn tiền 100% nếu có bất kỳ sự cố nào.",
    },
    {
      icon: <Zap size={28} className="highlight-icon text-success" />,
      title: "Đặt vé nhanh chóng",
      description: "Chọn chỗ trực quan theo sơ đồ thực tế, thanh toán an toàn và nhận vé điện tử tức thì.",
    },
    {
      icon: <Headphones size={28} className="highlight-icon text-warning" />,
      title: "Hỗ trợ tận tình 24/7",
      description: "Đội ngũ chăm sóc khách hàng luôn túc trực hỗ trợ bạn trong suốt quá trình trước và sau khi mua vé.",
    },
  ];

  return (
    <div className="highlights-section">
      <div className="highlights-grid">
        {highlights.map((item, index) => (
          <div key={index} className="highlight-card">
            <div className="highlight-icon-box">{item.icon}</div>
            <div className="highlight-content">
              <h4 className="highlight-title">{item.title}</h4>
              <p className="highlight-description">{item.description}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
