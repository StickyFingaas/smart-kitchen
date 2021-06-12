<template>
    <div>
        <h3>Kitchen Users</h3>
        <div class="row">
            <table class="col-12 table-class" v-if="users.length > 0">
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
                    <td><q-btn label="delete" name="delete" color="negative" @click="deleteRow(user.id)"></q-btn></td>
                </tr>
            </table>
            <span v-else>No entries!</span>
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
    deleteRow (id) {
      if (confirm('Are you sure you want to delete this user?')) {
        KitchenUserService.deleteUser(id).then(response => {
          if (response.status === 200) {
            this.afterDelete()
            console.log('wut')
          } else {
            console.log('Error')
            console.log(response)
          }
        })
          .catch(err => console.log(err))
      }
    },

    afterDelete () {
      this.$emit('afterDelete')
    }
  }
}
</script>

<style scoped>
    .row {
        width: 50vw;
    }
    .table-class {
        font-size: 16px;
        max-width: 35vw;
        text-align: left;
        border: 5px solid #1976D2;
        padding: 10px;
        display: flexbox;
        flex-direction: column;
    }

    h3 {
        font-size: 3em;
    }
    th {
        font-size: 1.2em;
        padding: 0 10px 5px 0;
        color: #1976D2;

    }
    td {
        padding: 7px;
        flex-shrink: 3;
        height: 20px;
        word-break: break-all;
    }

    tr:nth-child(2n){
        background-color: #1976D2;
        color: white;
    }
</style>
