import { Button, FloatingLabel, Form, FormGroup } from "react-bootstrap";
import { useAuth } from "../../hooks/useAuth";
import { useState } from "react";

export const LoginPage = () => {
  const { login } = useAuth();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  return (
    <>
      <Form>
        <FormGroup>
          <Form.Label htmlFor="email">Email address</Form.Label>
          <FloatingLabel
            controlId="floatingInput"
            label="Email address"
            className="mb-3"
          >
            <Form.Control
              type="email"
              placeholder="name@example.com"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </FloatingLabel>
        </FormGroup>

        <FormGroup>
          <Form.Label htmlFor="password">Password</Form.Label>
          <FloatingLabel
            controlId="floatingInput"
            label="Password"
            className="mb-3"
          >
            <Form.Control type="password" placeholder="Password" />
          </FloatingLabel>
        </FormGroup>
      </Form>
    </>
  );
};
