const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      {
        path: '/',
        component: () => import('pages/Index.vue')
      }

      // {
      //   name: 'User Table',
      //   path: '/userTable',
      //   component: () => import('components/KitchenUser/UserTable.vue')
      // }
    ]
  },
  // Always leave this as last one,
  // but you can also remove it

  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
