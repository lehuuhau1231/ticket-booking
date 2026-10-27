import { Ticket } from "lucide-react";
import { Button, Container, Nav, Navbar } from "react-bootstrap";
import { useAuth } from "../../hooks/useAuth";
import { useNavigate } from "react-router-dom";

export const Header = () => {
  const { user, login, logout } = useAuth();
  const navigate = useNavigate();

  const handleLogin = () => {
    login();
    navigate("/");
  };

  const handleLogout = () => {
    logout();
    navigate("/");
  };

  return (
    <Navbar bg="white" className="shadow-sm py-3">
      <Container>
        <Navbar.Brand
          href="/"
          className="fw-bold text-primary d-flex align-items-center gap-2"
        >
          <Ticket size={24} className="me-2" />
          Ticket Booking
        </Navbar.Brand>
        <Nav className="ms-auto d-flex align-items-center gap-3">
          {user ? (
            <>
              <Nav.Link href="/your-tickets" className="text-primary">
                Vé của tôi
              </Nav.Link>
              <Button variant="primary" onClick={handleLogout}>
                Đăng xuất
              </Button>
            </>
          ) : (
            <Button variant="primary" onClick={handleLogin}>
              Đăng nhập
            </Button>
          )}
        </Nav>
      </Container>
    </Navbar>
  );
};
