import { Outlet, Route, Routes } from "react-router-dom";
import { Authenticated } from "@refinedev/core";
import {
  CatchAllNavigate,
  NavigateToResource,
} from "@refinedev/react-router-v6";
import { ErrorComponent, ThemedLayoutV2, ThemedSiderV2 } from "@refinedev/antd";
import { Header } from "./components";
import {
  AppointmentCreate,
  AppointmentEdit,
  AppointmentList,
  AppointmentShow,
} from "./pages/appointments";
import {
  DoctorCreate,
  DoctorEdit,
  DoctorList,
  DoctorShow,
} from "./pages/doctors";
import {
  CategoryCreate,
  CategoryEdit,
  CategoryList,
  CategoryShow,
} from "./pages/patients";
import { Login } from "./pages/login";
import { Register } from "./pages/register";
import { ForgotPassword } from "./pages/forgotPassword";

const AppRoutes = () => {
  return (
    <Routes>
      <Route
        element={
          <Authenticated
            key="authenticated-inner"
            fallback={<CatchAllNavigate to="/login" />}
          >
            <ThemedLayoutV2
              Header={() => <Header sticky />}
              Sider={(props) => <ThemedSiderV2 {...props} fixed />}
            >
              <Outlet />
            </ThemedLayoutV2>
          </Authenticated>
        }
      >
        <Route index element={<NavigateToResource resource="blog_posts" />} />
        <Route path="/appointments">
          <Route index element={<AppointmentList />} />
          <Route path="create" element={<AppointmentCreate />} />
          <Route path="edit/:id" element={<AppointmentEdit />} />
          <Route path="show/:id" element={<AppointmentShow />} />
        </Route>
        <Route path="/doctors">
          <Route index element={<DoctorList />} />
          <Route path="create" element={<DoctorCreate />} />
          <Route path="edit/:id" element={<DoctorEdit />} />
          <Route path="show/:id" element={<DoctorShow />} />
        </Route>
        <Route path="/patients/">
          <Route index element={<CategoryList />} />
          <Route path="create" element={<CategoryCreate />} />
          <Route path="edit/:id" element={<CategoryEdit />} />
          <Route path="show/:id" element={<CategoryShow />} />
        </Route>
        <Route path="*" element={<ErrorComponent />} />
      </Route>
      <Route
        element={
          <Authenticated key="authenticated-outer" fallback={<Outlet />}>
            <NavigateToResource />
          </Authenticated>
        }
      >
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/forgot-password" element={<ForgotPassword />} />
      </Route>
    </Routes>
  );
};

export default AppRoutes;
