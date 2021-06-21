<template>
  <q-page class="row justify-center content-center offset-bit">
    <div class="row justify-center items-center col-10 q-gutter-xl">
      <div class="col-6">
        <item-table :key="tableKey" @afterDelete="afterItemSubmit()"/>
      </div>
      <div class="col-4">
        <item-form @onItemSubmit="afterItemSubmit()" /> <!-- Ovdje hvata $emit koji se desava unutar ItemForm; @ je isto kao v-on: -->
      </div>
    </div>
  </q-page>
</template>

<script>
import ItemTable from 'src/components/Item/ItemTable.vue'
import ItemForm from 'src/components/Item/ItemForm.vue'

export default {
  components: {
    ItemTable,
    ItemForm
  },
  name: 'PageItems',
  data () {
    return {
      tableKey: 0
    }
  },
  methods: {
    afterItemSubmit () {
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
