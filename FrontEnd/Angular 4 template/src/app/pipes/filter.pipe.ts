import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(objects: Array<Object>, field: string, value: string, ): Array<Object> {
    if (!field || !value) {
      return objects;
    }
    if (!objects) {
      return [];
    }
    return objects.filter(object => object[field].toLowerCase().includes(value.toLowerCase()));
  }

}
