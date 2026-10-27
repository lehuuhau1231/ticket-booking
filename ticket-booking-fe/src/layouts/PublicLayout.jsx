import { Container } from "react-bootstrap";
import { Header } from "../components/common/Header";
import { Outlet } from "react-router-dom";

export const PublicLayout = () => {
  return (
    <>
      <Header />
      <Container>
        <main>
          <Outlet />
        </main>
      </Container>
    </>
  );
};
