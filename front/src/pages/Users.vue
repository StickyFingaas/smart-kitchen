<template>
  <q-page class="row justify-center content-center offset-bit">
    <div class="row justify-center items-center col-10 q-gutter-xl">
      <div class="col-6">
        <user-table :key="tableKey" @afterDelete="afterAction()" />
      </div>
      <div class="col-4">
        <user-form @onUserSubmit="afterAction()"  />
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

<style lang="scss">

@media (max-width: 550px) {
    .offset-bit {
      margin-left: -70px;
    }
}

@media (max-width: 375px) {
    .offset-bit {
      margin-left: -105px;
    }
}
</style>
