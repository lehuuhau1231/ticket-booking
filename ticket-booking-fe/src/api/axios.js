import axios from "axios";

const BASE_URL = process.env.REACT_APP_BASE_URL || "http://localhost:8080/ticket-booking/api";

const instance = axios.create({
  baseURL: BASE_URL,
});

instance.interceptors.response.use(
  (response) => response.data,
  (error) => {
    return Promise.reject(error?.response?.data || error);
  }
);

export const createAuthApi = (token) => {
  const authInstance = axios.create({
    baseURL: BASE_URL,
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });

  authInstance.interceptors.response.use(
    (response) => response.data,
    (error) => {
      return Promise.reject(error?.response?.data || error);
    }
  );

  return authInstance;
};

export default instance;
