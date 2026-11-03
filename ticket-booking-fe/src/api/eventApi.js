import api from "./axios";

export const eventApi = {
  getEvents: ({ keyword, city, category, page = 0, size = 12 } = {}) => {
    const params = {};
    if (keyword && keyword.trim()) params.keyword = keyword.trim();
    if (city && city !== "all") params.city = city;
    if (category && category !== "ALL") params.category = category;
    params.page = page;
    params.size = size;

    return api.get("/events", { params });
  },

  getEventById: (id) => api.get(`/events/${id}`),
};
