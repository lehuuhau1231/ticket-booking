import { useState } from "react";
import { cities } from "../../data/cities";
import { Button, Container } from "react-bootstrap";
import { ChevronDown } from "lucide-react";

export const CitySelect = () => {
  const [cityInput, setCityInput] = useState("");
  const [isOpen, setIsOpen] = useState(false);

  return (
    <>
      <div>
        <Container>
          <button className="btn" onClick={() => setIsOpen(!isOpen)}>
            Tất cả địa điểm
          </button>
          <ChevronDown />
        </Container>
        {isOpen && (
          <>
            <input
              type="text"
              value={cityInput}
              onChange={(e) => setCityInput(e.target.value)}
            />
            {cities
              .filter((city) =>
                city.label.toLowerCase().includes(cityInput.toLowerCase()),
              )
              .map((city) => (
                <div key={city.value}>{city.label}</div>
              ))}
          </>
        )}
      </div>
    </>
  );
};
