const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      {
        path: '/',
        component: () => import('pages/Index.vue')
      },
      // recipe crud operation
      {
        name: 'Recipe',
        path: '/recipe',
        component: () => import('components/Recipe/Recipe.vue')
      },
      {
        name: 'Create-Recipe',
        path: '/create-recipe',
        component: () => import('components/Recipe/Create.vue')
      },
      {
        name: 'Edit-Recipe',
        path: '/edit-recipe',
        component: () => import('components/Recipe/Update.vue')
      },
      {
        name: 'Delete-Recipe',
        path: '/delete-recipe',
        component: () => import('components/Recipe/Delete.vue')
      },

      // user crud
      {
        name: 'Add-User',
        path: '/createKitchenUser',
        component: () => import('components/KitchenUser/NewUser.vue')
      },
      {
        name: 'Edit-User',
        path: '/updateKitchenUser',
        component: () => import('components/KitchenUser/UserEdit.vue')
      },
      {
        name: 'Show-Users',
        path: '/getAllKitchenUsers',
        component: () => import('components/KitchenUser/UserList.vue')
      }
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
