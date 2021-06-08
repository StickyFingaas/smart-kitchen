<template>
    <div>
        <h3>Kitchen Users</h3>
        <div class="row">
            <table class="col-12 table-class">
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Email</th>
                </tr>
                <tr v-for="user in users" :key="user.id">
                    <td>{{ user.id }}</td>
                    <td>{{ user.username }}</td>
                    <td>{{ user.password }}</td>
                    <td>{{ user.email }}</td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>
// import Vue from 'vue'
import KitchenUserService from '../../services/rest-services/kitchenuser.service.js'
export default {
  data () {
    return {
      // path: 'getAllKitchenUsers',
      users: []
    }
  },
  // async/await varijanta slanja http zahtjeva
  async created () {
    const response = await KitchenUserService.getAll()
    console.log(response)
    this.users = response.data
  },
  methods: {

  }
}
</script>

<style scoped>
    .table-class {
        width: 45vw;
        margin: auto;
        text-align: left;
        border: 5px solid #1976D2;
        padding: 10px;
        display: block;
    }

    th {
        font-size: 1.2em;
        padding: 0 10px 5px 0;
        color: #1976D2;

    }
    td {
        padding: 7px;
        word-break: break-all;
    }

    tr:nth-child(2n){
        background-color: lightslategray;
        color: white;
    }
</style>
