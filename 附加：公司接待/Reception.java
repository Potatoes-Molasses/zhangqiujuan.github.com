package communication;


/****
 * @InterfaceName:Reception
 * @Description:����ӿ�,����3�����󷽷�eat()�� accommodate()�� travel()
 * @author �����
 * @date 2018-10-20
 */
public interface Reception {
	
	public double eat(int days);
	public double accommodate(int days);
	public double travel(double fare);
	
}
