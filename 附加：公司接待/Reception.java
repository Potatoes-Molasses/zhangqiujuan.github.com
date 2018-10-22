package communication;


/****
 * @InterfaceName:Reception
 * @Description:定义接口,含有3个抽象方法eat()、 accommodate()和 travel()
 * @author 张秋娟
 * @date 2018-10-20
 */
public interface Reception {
	
	public double eat(int days);
	public double accommodate(int days);
	public double travel(double fare);
	
}
