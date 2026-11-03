import { createContext, useEffect, useReducer, useState } from "react";
import { userReducer } from "../reducers/UserReducer";
import { userApi } from "../api/userApi";
import { authApi } from "../api/authApi";

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, dispatch] = useReducer(userReducer, null);
  const [isLoading, setIsLoading] = useState(true);

  const login = async (userData) => {
    const loginResponse = await authApi.login(userData);

    const responseResult = loginResponse?.result;
    if (responseResult?.token) {
      localStorage.setItem("token", loginResponse.result.token);
    }
    const profile = responseResult?.userResponse || responseResult;
    dispatch({ type: "login", payload: profile });
    return loginResponse;
  };

  const logout = () => {
    localStorage.removeItem("token");
    dispatch({ type: "logout" });
  };

  const register = async (userData) => {
    const registerResponse = await authApi.register(userData);
    return registerResponse;
  };

  const getUserFromToken = async () => {
    const token = localStorage.getItem("token");
    if (token) {
      try {
        const userData = await userApi.getUser(token);
        dispatch({ type: "login", payload: userData.result });
      } catch (error) {
        console.error("Error fetching user data:", error);
        localStorage.removeItem("token");
        dispatch({ type: "logout" });
      } finally {
        setIsLoading(false);
      }
    } else {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    getUserFromToken();
  }, []);

  return (
    <AuthContext.Provider
      value={{
        user,
        dispatch,
        login,
        logout,
        register,
        isLoading,
        isAuthenticated: !!user,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};
