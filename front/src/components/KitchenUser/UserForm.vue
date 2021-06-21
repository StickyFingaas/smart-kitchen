<template>
    <q-form @submit="onSubmit" class="q-gutter-md">
        <div class="col">
            <q-input v-model="user.username" type="text" label="Username" outlined lazy-rules class="gib-padding" />
            <q-input
                class="q-nt-nd gib-padding"
                v-model="user.password"
                :type="isPwd ? 'password' : 'text'"
                label="Password"
                outlined
            >
                <template v-slot:append>
                    <q-icon
                        :name="isPwd ? 'visibility_off' : 'visibility'"
                        class="cursor-pointer"
                        @click="isPwd = !isPwd"
                    />
                </template>
            </q-input>
            <q-input
                class="q-nt-nd gib-padding"
                v-model="user.email"
                type="text"
                label="Email"
                outlined
            />
        </div>
        <div>
            <q-btn label="Submit" type="submit" color="accent" />
        </div>
    </q-form>
</template>

<script>
// import Vue from 'vue'
import KitchenUserService from '../../services/rest-services/kitchenuser.service.js'

export default {
  data () {
    return {
      path: 'createKitchenUser',
      user: {
        username: null,
        password: null,
        email: null
      },
      isPwd: true
    }
  },
  methods: {
    onSubmit () {
      // callback varijanta slanja http zahtjeva
      KitchenUserService.createUser(this.user).then(response => {
        if (response.status === 200) {
          this.postSubmit()
          this.resetUser()
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
      this.$emit('onUserSubmit')
    },
    resetUser () {
      this.user = {
        username: null,
        password: null,
        email: null
      }
    }
  }
}
</script>

<style lang="scss" scoped>
  .col {
    min-width: 200px;
  }
  .gib-padding {
    padding-bottom: 5px;
  }
</style>
