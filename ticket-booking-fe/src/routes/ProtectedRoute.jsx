import { Navigate, Outlet, useLocation } from "react-router-dom";
import { Spinner } from "react-bootstrap";
import { useAuth } from "../hooks/useAuth";

export const ProtectedRoute = () => {
  const { user, isLoading } = useAuth();
  const token = localStorage.getItem("token");
  const location = useLocation();

  if (isLoading) {
    return (
      <div className="d-flex justify-content-center align-items-center py-5 my-5">
        <Spinner animation="border" variant="primary" role="status">
          <span className="visually-hidden">Đang tải...</span>
        </Spinner>
      </div>
    );
  }

  if (!user || !token) {
    return <Navigate to="/login" replace state={{ from: location }} />;
  }

  return <Outlet />;
};
