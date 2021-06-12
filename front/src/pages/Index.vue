<template>
  <q-page class="flex flex-center">
    <!-- <img
      alt="Quasar logo"
      src="~assets/quasar-logo-full.svg"
    > -->
    <div class="row">
      <div class="col-6">
        <user-table :key="tableKey" @afterDelete=afterAction() />
      </div>
      <div class="col-5 offset-1" style="margin-top:150px">
        <user-form @onUserSubmit=afterAction()  />
      </div>
    </div>
  </q-page>
</template>

<script>
import UserTable from 'src/components/KitchenUser/UserTable.vue'
import UserForm from 'src/components/KitchenUser/UserForm.vue'
// import EditForm from 'src/components/KitchenUser/EditForm.vue'

export default {
  components: {
    UserTable,
    UserForm
    // EditForm
  },
  name: 'PageIndex',
  data () {
    return {
      tableKey: 0
    }
  },
  methods: {
    afterAction () {
      this.tableKey++
    }
  }
}
</script>
