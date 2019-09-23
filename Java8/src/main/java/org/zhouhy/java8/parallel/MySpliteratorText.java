package org.zhouhy.java8.parallel;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
* <p>className: MySpliteratorText</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月23日
*/
public class MySpliteratorText {

	private final String[] data;
	
	public MySpliteratorText(String text) {
        Objects.requireNonNull(text, "The parameter can not be null");
        this.data = text.split("\n");
    }
	
	private class MySpliterator implements Spliterator<String> {

		private int start, end;

        public MySpliterator() {
            this.start = 0;
            this.end = MySpliteratorText.this.data.length - 1;
        }

        public MySpliterator(int start, int end) {
            this.start = start;
            this.end = end;
        }
		
		@Override
		public boolean tryAdvance(Consumer<? super String> action) {
			if (start <= end) {
                action.accept(MySpliteratorText.this.data[start++]);
                return true;
            }
			return false;
		}

		@Override
		public Spliterator<String> trySplit() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long estimateSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int characteristics() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
