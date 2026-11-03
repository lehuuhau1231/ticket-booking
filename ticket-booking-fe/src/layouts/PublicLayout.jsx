import React from "react";
import { Header } from "../components/common/Header";
import { Footer } from "../components/common/Footer";
import { Outlet } from "react-router-dom";

export const PublicLayout = () => {
  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />
      <main className="flex-grow-1">
        <Outlet />
      </main>
      <Footer />
    </div>
  );
};
