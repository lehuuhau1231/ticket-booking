import axios from "axios";

const BASE_URL = process.env.REACT_APP_BASE_URL;
console.log("BASE_URL:", BASE_URL);

export const createAuthApi = (token) =>
  axios.create({
    baseURL: BASE_URL,
    Headers: {
      Authorization: `Bearer ${token}`,
    },
  });

export default axios.create({
  baseURL: BASE_URL,
});
