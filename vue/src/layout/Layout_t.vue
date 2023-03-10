<template>
  <div>
    <t_Header/>
    <div style="display: flex">
      <t_Aside/>
      <router-view style="flex: 1"/>
    </div>
  </div>
</template>

<script>


import t_Header from "@/components/t_Header";
import t_Aside from "@/components/t_Aside";

export default {
  name: "Layout_t",
  components: {
    t_Header,
    t_Aside,
  }
}
</script>

<style scoped>

</style>