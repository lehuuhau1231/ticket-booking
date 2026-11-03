import React from "react";
import { Ticket, Mail, Phone } from "lucide-react";
import { Container, Row, Col } from "react-bootstrap";
import "./Footer.css";

export const Footer = () => {
  return (
    <footer className="main-footer">
      <Container>
        <Row className="gy-4">
          <Col lg={4} md={6}>
            <div className="footer-brand d-flex align-items-center gap-2 mb-3">
              <Ticket size={24} className="text-primary" />
              <span className="fw-bold fs-5 text-dark">Ticket Booking</span>
            </div>
            <p className="footer-text">
              Nền tảng đặt vé trực tuyến hàng đầu cho các sự kiện âm nhạc, điện
              ảnh, thể thao và sân khấu giải trí tại Việt Nam.
            </p>
            <div className="footer-contact-info">
              <div className="contact-item">
                <Mail size={16} className="contact-icon" />
                <span>support@ticketbooking.vn</span>
              </div>
              <div className="contact-item">
                <Phone size={16} className="contact-icon" />
                <span>1900 1234 (8:00 - 22:00)</span>
              </div>
            </div>
          </Col>

          <Col lg={2} md={6} sm={6}>
            <h5 className="footer-title">Khám phá</h5>
            <ul className="footer-links">
              <li><a href="/#events">Sự kiện âm nhạc</a></li>
              <li><a href="/#events">Phim chiếu rạp</a></li>
              <li><a href="/#events">Kịch sân khấu</a></li>
              <li><a href="/#events">Giải chạy thể thao</a></li>
              <li><a href="/#events">Hội thảo công nghệ</a></li>
            </ul>
          </Col>

          <Col lg={3} md={6} sm={6}>
            <h5 className="footer-title">Hỗ trợ khách hàng</h5>
            <ul className="footer-links">
              <li><a href="#!">Hướng dẫn đặt vé</a></li>
              <li><a href="#!">Chính sách hoàn hủy vé</a></li>
              <li><a href="#!">Câu hỏi thường gặp (FAQ)</a></li>
              <li><a href="#!">Quy chế hoạt động</a></li>
              <li><a href="#!">Chính sách bảo mật thông tin</a></li>
            </ul>
          </Col>

          <Col lg={3} md={6}>
            <h5 className="footer-title">Phương thức thanh toán</h5>
            <p className="footer-text mb-3">
              Hỗ trợ thanh toán bảo mật đa dạng qua các ngân hàng và ví điện tử:
            </p>
            <div className="payment-badges">
              <span className="payment-pill">VNPAY</span>
              <span className="payment-pill">MOMO</span>
              <span className="payment-pill">VISA / Master</span>
              <span className="payment-pill">ATM Nội Địa</span>
            </div>
          </Col>
        </Row>

        <div className="footer-bottom">
          <p className="copyright-text mb-0">
            © {new Date().getFullYear()} Ticket Booking System. Mọi quyền được bảo lưu. Thiết kế chân thực, tiện lợi và an toàn.
          </p>
        </div>
      </Container>
    </footer>
  );
};
