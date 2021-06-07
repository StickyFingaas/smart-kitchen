<template>
  <div id="q-app">
    <nav class="navbar navbar-expand navbar-dark float-right bg-dark">
      <router-link to="/getAllKitchenUsers" class="navbar-brand">Users</router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/createKitchenUser" class="nav-link">Add a user</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/updateKitchenUser" class="nav-link">Edit a user</router-link>
        </li>
      </div>
      <div>
        <button value="submit">Submit</button>
      </div>
    </nav>

    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>
<script>
export default {
  name: 'App'
}
</script>
