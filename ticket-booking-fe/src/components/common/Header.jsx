import React from "react";
import {
  Navbar,
  Container,
  Nav,
  Button,
  Dropdown,
  Badge,
} from "react-bootstrap";
import { Ticket, User as UserIcon, LogOut, TicketCheck } from "lucide-react";
import { Link, useNavigate } from "react-router-dom";
import toast from "react-hot-toast";
import { useAuth } from "../../hooks/useAuth";

export const Header = () => {
  const { user, logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    toast.success("Đã đăng xuất thành công!");
    navigate("/");
  };

  return (
    <Navbar bg="white" expand="lg" className="shadow-sm py-2 sticky-top">
      <Container>
        {/* Brand */}
        <Navbar.Brand
          as={Link}
          to="/"
          className="fw-bold text-primary d-flex align-items-center gap-2"
        >
          <div
            className="d-flex align-items-center justify-content-center bg-primary text-white rounded-3 p-1"
            style={{ width: "32px", height: "32px" }}
          >
            <Ticket size={20} />
          </div>
          <span className="fs-5 tracking-tight">Ticket Booking</span>
        </Navbar.Brand>

        <Navbar.Toggle aria-controls="navbar-nav" />

        <Navbar.Collapse id="navbar-nav">
          <Nav className="ms-auto d-flex align-items-lg-center gap-2 gap-lg-3 mt-3 mt-lg-0">
            {user ? (
              <>
                <Nav.Link
                  as={Link}
                  to="/your-tickets"
                  className="d-flex align-items-center gap-2 text-secondary fw-medium px-2"
                >
                  <TicketCheck size={18} className="text-primary" />
                  <span>Vé của tôi</span>
                </Nav.Link>

                {/* User Dropdown */}
                <Dropdown align="end">
                  <Dropdown.Toggle
                    variant="light"
                    id="user-dropdown"
                    className="d-flex align-items-center gap-2 border bg-white rounded-pill px-3 py-1 shadow-none"
                  >
                    <div
                      className="bg-primary-subtle text-primary rounded-circle d-flex align-items-center justify-content-center"
                      style={{ width: "28px", height: "28px" }}
                    >
                      <UserIcon size={16} />
                    </div>
                    <span
                      className="small fw-semibold text-dark text-truncate"
                      style={{ maxWidth: "160px" }}
                    >
                      {user.email || "Tài khoản"}
                    </span>
                  </Dropdown.Toggle>

                  <Dropdown.Menu className="shadow-sm border-0 rounded-3 mt-2 p-2">
                    <div className="px-3 py-2">
                      <div className="small text-muted">Đăng nhập với</div>
                      <div
                        className="fw-semibold text-dark text-truncate"
                        style={{ maxWidth: "200px" }}
                      >
                        {user.email}
                      </div>
                      {user.role && (
                        <div className="mt-1">
                          <Badge
                            bg={user.role === "ADMIN" ? "danger" : "primary"}
                            className="text-uppercase"
                            style={{ fontSize: "0.7rem" }}
                          >
                            {user.role}
                          </Badge>
                        </div>
                      )}
                    </div>

                    <Dropdown.Divider />

                    <Dropdown.Item
                      as={Link}
                      to="/your-tickets"
                      className="d-flex align-items-center gap-2 py-2 rounded-2"
                    >
                      <TicketCheck size={16} className="text-secondary" />
                      <span>Vé đã đặt</span>
                    </Dropdown.Item>

                    <Dropdown.Divider />

                    <Dropdown.Item
                      onClick={handleLogout}
                      className="d-flex align-items-center gap-2 py-2 rounded-2 text-danger"
                    >
                      <LogOut size={16} />
                      <span>Đăng xuất</span>
                    </Dropdown.Item>
                  </Dropdown.Menu>
                </Dropdown>
              </>
            ) : (
              <div className="d-flex align-items-center gap-2">
                <Button
                  variant="outline-primary"
                  className="fw-medium px-3 rounded-pill"
                  onClick={() => navigate("/login")}
                >
                  Đăng nhập
                </Button>
                <Button
                  variant="primary"
                  className="fw-medium px-3 rounded-pill"
                  onClick={() => navigate("/register")}
                >
                  Đăng ký
                </Button>
              </div>
            )}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};
