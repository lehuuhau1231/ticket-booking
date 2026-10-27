import { Col, Container, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { cities } from "../../data/cities";
import { useState } from "react";
import { CitySelect } from "../../components/citySelect/CitySelect";

export const Home = () => {
  const navigate = useNavigate();
  const [cityInput, setCityInput] = useState();
  console.log(cityInput);

  return (
    <>
      <Container>
        <Row>
          <Col>Tên sự kiện</Col>
          <Col>
            <CitySelect />
          </Col>
        </Row>
      </Container>
    </>
  );
};
