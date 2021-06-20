<template>
    <div>
        <div class="row">
            <q-table
              class="my-sticky-header-table"
              title="Users"
              :data="users"
              :columns="columns"
              virtual-scroll
              :pagination.sync="pagination"
              :rows-per-page-options="[0]"
              :virtual-scroll-sticky-size-start="48"
              flat
              bordered
            >
            <template v-slot:header="props">
              <q-tr :props="props">
                <q-th auto-width />
                  <q-th
                  v-for="col in props.cols"
                  :key="col.name"
                  :props="props"
                  >
                    {{ col.label }}
                </q-th>
                <q-th auto-width />
              </q-tr>
            </template>
            <template v-slot:body="props">
              <q-tr :props="props">
                <q-td auto-width>
                  <q-btn size="sm" color="accent" icon="delete" round dense @click="deleteRow(props.row.id)" />
                </q-td>
                <q-td
                v-for="col in props.cols"
                  :key="col.name"
                  :props="props"
                >
                <span v-if="tagEditingID == props.row.id">
                  <q-input class="editInput" v-model="col.value" :for='`edit-id-${props.row.id}`' outlined/>
                  </span>
                  <span v-else>
                    <!-- hocu da se svaka od 3 vrijednosti iz jednog reda i props.row.id
                    asociraju na 4 parametra korisnika koji su zakomentarisani dolje -->
                  {{ col.value }}
                  </span>
                </q-td>
                <q-td auto-width>
                  <span v-if="tagEditingID != props.row.id">
                  <q-btn size="sm" color="accent" icon="edit" round dense @click="setEditingID(props.row.id)" />
                  </span>
                  <span v-else>
                    <!-- na klik ovog dugmeta treba da odradi editRow gdje uzima 4 parametra korisnika
                    id, username, pass, email
                    i odradi zahtjev ka quarkusovom api gdje merge-uje korisnika -->
                  <q-btn size="sm" color="accent" icon="done" round dense @click="editRow()"/>
                  </span>
                  <span v-if="tagEditingID == props.row.id">
                    <br><br>
                    <q-btn size="sm" color="negative" icon="cancel" round dense @click="reset()"/>
                  </span>
                </q-td>
              </q-tr>
            </template>
            </q-table>
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
      users: [],
      editUser: {
        id: null,
        username: null,
        password: null,
        email: null
      },
      pagination: {
        rowsPerPage: 0
      },
      tagEditingID: '',
      columns: [
        { name: 'USERNAME', label: 'USERNAME', field: 'username', sortable: true },
        { name: 'PASSWORD', label: 'PASSWORD', field: 'password', sortable: true },
        { name: 'EMAIL', label: 'EMAIL', field: 'email', sortable: true }

      ]
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
            console.log('Success')
          } else {
            console.log('Error')
            console.log(response)
          }
        })
          .catch(err => console.log(err))
      }
    },
    editRow () {
      // if (confirm('Are you sure you want to update this user?')) {
      //   KitchenUserService.updateUser(this.editUser).then(response => {}).catch(err => console.log(err))
      // }
    },
    setEditingID (id) {
      this.tagEditingID = id
      setTimeout(() => {
        document.getElementById(`edit-id-${id}`).focus()
      }, 1)
    },
    reset () {
      this.tagEditingID = ''
    },
    afterDelete () {
      this.$emit('afterDelete')
    }
  }
}
</script>

<style lang="scss">
  .q-table__top,
    .q-table__bottom,
    thead tr:first-child th {
      background-color: $primary;
      color: $secondary;
    }

thead tr th {
      position: sticky;
      top: 0;
      z-index: 1;
    }
  .my-sticky-header-table {
    min-width: 300px;
    height: 350px;
    width: 100%;
  }
</style>
