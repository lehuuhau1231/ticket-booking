import { createAuthApi } from "./axios";

export const userApi = {
  getUser: (token) => createAuthApi(token).get("/user"),
};
