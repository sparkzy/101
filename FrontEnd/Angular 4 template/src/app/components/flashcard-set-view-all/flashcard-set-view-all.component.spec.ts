import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlashcardSetViewAllComponent } from './flashcard-set-view-all.component';

describe('FlashcardSetViewAllComponent', () => {
  let component: FlashcardSetViewAllComponent;
  let fixture: ComponentFixture<FlashcardSetViewAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlashcardSetViewAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlashcardSetViewAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
