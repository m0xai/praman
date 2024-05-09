import axios, { AxiosRequestConfig } from "axios";
import { TOKEN_KEY } from "../authProvider";

export const axiosInstance = axios.create();

axiosInstance.interceptors.request.use((request: AxiosRequestConfig) => {
  // Retrieve the token from local storage
  const token = localStorage.getItem(TOKEN_KEY)!;
  // Check if the header property exists
  if (request.headers) {
    // Set the Authorization header if it exists
    request.headers["Authorization"] = `Bearer ${token}`;
  } else {
    // Create the headers property if it does not exist
    request.headers = {
      Authorization: `Bearer ${token}`,
    };
  }

  return request;
});
