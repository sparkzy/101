import { Injectable } from '@angular/core';

@Injectable()
export class DynamicSortService {

  constructor() { }

  dynamicSort(property: string) {
    let sortOrder = 1;
    if (property[0] === '-') {
      sortOrder = -1;
      property = property.substr(1);
    }
    return function (a, b) {
      const result = (a[property] < b[property]) ? -1 : (a[property] > b[property]) ? 1 : 0;
      return result * sortOrder;
    };
  }

  arraySort(array: Array<object>, property: string) {
    array.sort(this.dynamicSort(property));
  }

}
