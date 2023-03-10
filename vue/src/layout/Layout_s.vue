<template>
  <div>
    <s_Header/>
    <div style="display: flex">
      <s_Aside/>
      <router-view style="flex: 1"/>
    </div>
  </div>
</template>

<script>
import s_Header from "@/components/s_Header";
import s_Aside from "@/components/s_Aside";

export default {
  name: "Layout_s",
  components: {
    s_Header,
    s_Aside,
  }
}
</script>

<style scoped>

</style>