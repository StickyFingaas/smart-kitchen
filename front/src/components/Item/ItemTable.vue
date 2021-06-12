<template>
    <div>
        <h3>Kitchen Items</h3>
        <div class="row">
            <table class="col-12 table-class">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Condition</th>
                </tr>
                <tr v-for="item in items" :key="item.id">
                    <td>{{ item.id }}</td>
                    <td>{{ item.name }}</td>
                    <td>{{ item.price }}</td>
                    <td>{{ item.condition }}</td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>
// import Vue from 'vue'
// Importovanje servisa umjesto cumbersome Vuea i stalnog rada sa njim, sve definisano u servisu
import ItemService from '../../services/rest-services/item.service.js'
export default {
  data () {
    return {
      // path: 'getAllKitchenUsers',
      items: []
    }
  },
  // async/await varijanta slanja http zahtjeva kad god ocekujemo neku povratnu informaciju sa servera za npr. prikaz ili proracun
  // , veoma dobro za nauciti
  async created () {
    const response = await ItemService.getAllItems()
    console.log(response)
    this.items = response.data // Cilja listu koja se nalazi u data()
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
