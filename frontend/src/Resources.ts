const Resources = [
  {
    name: "appointments",
    list: "/appointments",
    create: "/appointments/create",
    edit: "/appointments/edit/:id",
    show: "/appointments/show/:id",
    meta: {
      canDelete: true,
    },
  },
  {
    name: "doctors",
    list: "/doctors",
    create: "/doctors/create",
    edit: "/doctors/edit/:id",
    show: "/doctors/show/:id",
    meta: {
      canDelete: true,
    },
  },
  {
    name: "patients",
    list: "/patients/",
    create: "/patients/create",
    edit: "/patients/edit/:id",
    show: "/patients/show/:id",
    meta: {
      canDelete: true,
    },
  },
];

export default Resources;
