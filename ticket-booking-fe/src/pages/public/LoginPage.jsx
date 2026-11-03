import React, { useState, useEffect } from "react";
import { Form, Button, Alert, Spinner } from "react-bootstrap";
import { Link, useNavigate, useLocation } from "react-router-dom";
import { Ticket, Eye, EyeOff } from "lucide-react";
import toast from "react-hot-toast";
import { useAuth } from "../../hooks/useAuth";
import "./LoginPage.css";

export const LoginPage = () => {
  const { user, login, isLoading } = useAuth();
  const navigate = useNavigate();
  const location = useLocation();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [rememberMe, setRememberMe] = useState(false);
  const [showPassword, setShowPassword] = useState(false);
  const [formErrors, setFormErrors] = useState({});
  const [serverError, setServerError] = useState("");
  const [isSubmitting, setIsSubmitting] = useState(false);

  // Điền trước email nếu người dùng đã chọn Remember Me
  useEffect(() => {
    const savedEmail = localStorage.getItem("rememberedEmail");
    if (savedEmail) {
      setEmail(savedEmail);
      setRememberMe(true);
    }
  }, []);

  // Tự động chuyển hướng nếu người dùng đã đăng nhập từ trước
  useEffect(() => {
    if (!isLoading && user) {
      const redirectPath = location.state?.from?.pathname || "/";
      navigate(redirectPath, { replace: true });
    }
  }, [user, isLoading, navigate, location]);

  const validate = () => {
    const errors = {};
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!email.trim()) {
      errors.email = "Vui lòng nhập địa chỉ email";
    } else if (!emailRegex.test(email.trim())) {
      errors.email = "Địa chỉ email không hợp lệ";
    }

    if (!password) {
      errors.password = "Vui lòng nhập mật khẩu";
    } else if (password.length < 6) {
      errors.password = "Mật khẩu phải chứa ít nhất 6 ký tự";
    }

    setFormErrors(errors);
    return Object.keys(errors).length === 0;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setServerError("");

    if (!validate()) {
      return;
    }

    setIsSubmitting(true);
    try {
      await login({
        email: email.trim(),
        password,
      });

      // Lưu hoặc xóa email ghi nhớ
      if (rememberMe) {
        localStorage.setItem("rememberedEmail", email.trim());
      } else {
        localStorage.removeItem("rememberedEmail");
      }

      toast.success("Đăng nhập thành công!");
      const redirectPath = location.state?.from?.pathname || "/";
      navigate(redirectPath, { replace: true });
    } catch (error) {
      console.error("Login failed:", error);
      const message =
        error?.message ||
        error?.response?.data?.message ||
        "Email hoặc mật khẩu không chính xác. Vui lòng thử lại!";
      setServerError(message);
      toast.error(message);
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <div className="login-page-container">
      <div className="login-card">
        {/* Header */}
        <div className="login-header">
          <div className="login-brand-icon">
            <Ticket size={28} />
          </div>
          <h1 className="login-title">Chào mừng trở lại</h1>
          <p className="login-subtitle">
            Đăng nhập để quản lý và đặt vé sự kiện của bạn
          </p>
        </div>

        {/* Server Error Alert */}
        {serverError && (
          <Alert variant="danger" className="py-2 px-3 small">
            {serverError}
          </Alert>
        )}

        {/* Form */}
        <Form onSubmit={handleSubmit} noValidate>
          {/* Email */}
          <Form.Group className="mb-3" controlId="loginEmail">
            <Form.Label className="small fw-semibold text-secondary mb-1">
              Địa chỉ Email
            </Form.Label>
            <div className="login-input-group">
              <Form.Control
                type="email"
                placeholder="name@example.com"
                value={email}
                onChange={(e) => {
                  setEmail(e.target.value);
                  if (formErrors.email) {
                    setFormErrors((prev) => ({ ...prev, email: "" }));
                  }
                }}
                isInvalid={!!formErrors.email}
                disabled={isSubmitting}
                autoComplete="email"
              />
              <Form.Control.Feedback type="invalid">
                {formErrors.email}
              </Form.Control.Feedback>
            </div>
          </Form.Group>

          {/* Password */}
          <Form.Group className="mb-3" controlId="loginPassword">
            <div className="d-flex justify-content-between align-items-center mb-1">
              <Form.Label className="small fw-semibold text-secondary mb-0">
                Mật khẩu
              </Form.Label>
              <Link
                to="#"
                className="small text-decoration-none text-muted"
                onClick={(e) => {
                  e.preventDefault();
                  toast("Tính năng quên mật khẩu đang được phát triển!", {
                    icon: "ℹ️",
                  });
                }}
              >
                Quên mật khẩu?
              </Link>
            </div>
            <div className="login-input-group">
              <Form.Control
                type={showPassword ? "text" : "password"}
                placeholder="Nhập mật khẩu (tối thiểu 6 ký tự)"
                value={password}
                onChange={(e) => {
                  setPassword(e.target.value);
                  if (formErrors.password) {
                    setFormErrors((prev) => ({ ...prev, password: "" }));
                  }
                }}
                isInvalid={!!formErrors.password}
                disabled={isSubmitting}
                autoComplete="current-password"
              />
              <button
                type="button"
                className="login-password-toggle"
                onClick={() => setShowPassword((prev) => !prev)}
                tabIndex={-1}
                aria-label={showPassword ? "Ẩn mật khẩu" : "Hiện mật khẩu"}
              >
                {showPassword ? <EyeOff size={18} /> : <Eye size={18} />}
              </button>
              <Form.Control.Feedback type="invalid">
                {formErrors.password}
              </Form.Control.Feedback>
            </div>
          </Form.Group>

          {/* Remember me */}
          <Form.Group className="mb-4" controlId="rememberMe">
            <Form.Check
              type="checkbox"
              label="Ghi nhớ tài khoản trên thiết bị này"
              checked={rememberMe}
              onChange={(e) => setRememberMe(e.target.checked)}
              className="small text-secondary"
              disabled={isSubmitting}
            />
          </Form.Group>

          {/* Submit Button */}
          <Button
            type="submit"
            variant="primary"
            className="w-100 login-btn-submit d-flex align-items-center justify-content-center gap-2"
            disabled={isSubmitting}
          >
            {isSubmitting ? (
              <>
                <Spinner
                  as="span"
                  animation="border"
                  size="sm"
                  role="status"
                  aria-hidden="true"
                />
                <span>Đang xử lý...</span>
              </>
            ) : (
              <span>Đăng nhập</span>
            )}
          </Button>
        </Form>

        {/* Divider */}
        <div className="login-divider">
          <span>HOẶC</span>
        </div>

        {/* Footer */}
        <div className="text-center small text-secondary">
          Chưa có tài khoản?{" "}
          <Link to="/register" className="login-footer-link">
            Đăng ký ngay
          </Link>
        </div>
      </div>
    </div>
  );
};
