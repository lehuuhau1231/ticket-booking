import { FloatingLabel, Form } from "react-bootstrap";
import { useAuth } from "../../hooks/useAuth";

export const RegisterPage = () => {
  const { register } = useAuth();
  return (
    <>
      <FloatingLabel
        controlId="floatingInput"
        label="Email address"
        className="mb-3"
      >
        <Form.Control type="email" placeholder="name@example.com" />
      </FloatingLabel>
      <FloatingLabel
        controlId="floatingPassword"
        label="Password"
        className="mb-3"
      >
        <Form.Control type="password" placeholder="Password" />
      </FloatingLabel>
    </>
  );
};
