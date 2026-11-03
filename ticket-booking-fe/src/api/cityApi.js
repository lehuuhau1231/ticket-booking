import api from "./axios";

export const cityApi = {
  getCities: () => api.get("/cities"),
};
