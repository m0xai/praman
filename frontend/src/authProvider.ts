import { AuthBindings } from "@refinedev/core";
import axios from "axios";

export const TOKEN_KEY = "refine-auth";

export const authProvider: AuthBindings = {
  login: async ({ email, password }) => {
    if (email && password) {
      const auth = await fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        redirect: "follow",
        body: JSON.stringify({ email, password }),
      });
      if (auth.status === 200) {
        const token = auth.headers.get("authorization");
        localStorage.setItem(TOKEN_KEY, token!);
        axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
        return {
          success: true,
          redirectTo: "/",
        };
      }
    }
    return {
      success: false,
      error: {
        name: "LoginError",
        message: "Invalid username or password",
      },
    };
  },

  logout: async () => {
    localStorage.removeItem(TOKEN_KEY);
    return {
      success: true,
      redirectTo: "/login",
    };
  },

  check: async () => {
    const token = localStorage.getItem(TOKEN_KEY);
    if (token) {
      return {
        authenticated: true,
      };
    }

    return {
      authenticated: false,
      redirectTo: "/login",
    };
  },

  getPermissions: async () => null,

  getIdentity: async () => {
    const token = localStorage.getItem(TOKEN_KEY);
    if (token) {
      return {
        id: 1,
        name: "John Doe",
        avatar: "https://i.pravatar.cc/300",
      };
    }
    return null;
  },

  onError: async (error) => {
    console.error(error);
    return { error };
  },
};
