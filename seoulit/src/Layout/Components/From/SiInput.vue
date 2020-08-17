
<template>
   <div 
   class="el-input el-input--suffix"
   slot="reference">
    <input
     type="text"
     class="el-input__inner"
     :value='iValue'
     @input="$emit('update:iValue', $event.target.value)"
     :disabled="disabled" />
    </div>
</template>

<script>
export default {
  props: {
    iValue: String,
    disabled: Boolean
  }
}
</script>