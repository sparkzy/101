import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchpostComponent } from './searchpost.component';

describe('SearchpostComponent', () => {
  let component: SearchpostComponent;
  let fixture: ComponentFixture<SearchpostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchpostComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchpostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
