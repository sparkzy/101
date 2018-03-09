import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindFlashcardsComponent } from './find-flashcards.component';

describe('FindFlashcardsComponent', () => {
  let component: FindFlashcardsComponent;
  let fixture: ComponentFixture<FindFlashcardsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindFlashcardsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindFlashcardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
