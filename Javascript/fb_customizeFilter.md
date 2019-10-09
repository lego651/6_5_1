## 1.Write a javascript function:
Given data:
const data = [
  { type: 'phone', color: 'gold', name: 'iphone' },
  { type: 'phone', color: 'blue', name: 'iphone' },
  { type: 'tv', color: 'blue', name: 'samsung' }];
And exclude rules:
const excludes = [{ k: 'color', v: 'gold' }, { k: 'type', v: 'tv' }]
// Print filtered data
For above example, we will expect:
res = [{ type: 'phone', color: 'blue', name: 'iphone' }];

your function will be like:

function myFilter(data, excluded) {
  ...

  return arr;
}

then call this function like:
const resArray = myFilter(data, excluded);
