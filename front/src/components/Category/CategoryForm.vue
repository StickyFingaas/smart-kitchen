<template>
    <q-form @submit="onSubmit" class="q-gutter-md">
        <div class="col">
            <q-input v-model="category.name" type="text" label="Name" outlined lazy-rules class="gib-padding"/>
        </div>
        <div>
            <q-btn label="Submit" type="submit" color="accent"/>
        </div>
    </q-form>
</template>

<script>
// import Vue from 'vue'
// Ista stvar sa importom da se ne mora peglati oko rada sa Vue objektom
import CategoryService from '../../services/rest-services/category.service.js'

export default {
  data () {
    return {
      path: 'createCategory',
      category: {
        name: null
      }
    }
  },
  methods: {
    onSubmit () {
      // callback varijanta slanja http zahtjeva
      CategoryService.createCategory(this.category).then(response => {
        if (response.status === 200) {
          this.postSubmit()
          this.resetCategory()
        } else {
          console.log('Error')
          console.log(response)
        }
      })
        .catch(err => {
          console.log(err)
        })
    },
    postSubmit () {
      this.$emit('onCategorySubmit') // Vue ugradjena metoda za emitovanje objekta koji onda glavni page moze da uhvati
    },
    // Resetuje formu nakon submita
    resetCategory () {
      this.category = {
        name: null
      }
    }
  }
}
</script>

<style scoped lang="scss">
  .col {
    min-width: 200px;
  }

  .gib-padding {
    padding-bottom: 5px;
  }
</style>
