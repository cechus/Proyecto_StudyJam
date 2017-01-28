package com.example.patty.text;

        import android.content.Context;
        import android.content.res.Resources;
        import android.graphics.BitmapFactory;
        import android.graphics.Color;
        import android.graphics.EmbossMaskFilter;
        import android.graphics.Paint;
        import android.graphics.RadialGradient;
        import android.graphics.Rect;
        import android.graphics.Shader;
        import android.graphics.Typeface;
        import android.os.Environment;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.RelativeLayout;
        import android.graphics.Canvas;
        import android.graphics.Bitmap;

        import java.io.File;
        import java.io.FileOutputStream;
        import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Resources mResources;
    private RelativeLayout mRelativeLayout;
    private Button mButton;
    private ImageView mImageView;
    private Random mRandom = new Random();
    private int images[]={R.drawable.uno, R.drawable.dos,R.drawable.tres,R.drawable.cuatro,R.drawable.cinco};
    private String textos[]={
            "De todo corazón te deseamos\nMuchas Felicidades\ny éxitos en tu vida.",
            "El mejor regalo que me pueden\nhacer esta Navidad es tu AMISTAD,\n gracias por ser mi amigo.",
            "El mejor regalo que me pueden \nhacer esta Navidad es tu AMISTAD,\n gracias por ser mi amiga.",
            "No hay mejor adorno \npara el arbolito de Navidad,\n que una sonrisa.",
            "No hay mejor regalo \nque encontrar bajo el arbolito,\n que el amor de nuestra familia.",
            "Te deseo de todo corazón\n una Navidad feliz, \npara ti y tu familia.",
            "¡Feliz Navidad \ny un Próspero Año Nuevo!.",
            "Si fuera una estrella\n fugaz escribiría en lo alto del cielo.\n ¡Feliz Navidad! \nPorque es lo que te deseo...","A ti y a todos los que nunca pierden\n la fe y la esperanza, \nles deseo una Feliz Navidad.",
            "Feliz Navidad para ti\n y todos los que comparten el deseo de un mundo mejor,\n lleno de paz y esperanza.",
            "En esta Navidad quiero pasarlo bien,\n pero te deseo que tú lo pases\n aún mejor que yo...",
            "¡Feliz Navidad! \nEspero que tu rutina se convierta en sorpresa,\n los enfados en sonrisas \ny las tristezas en esperanzas.",
            "La noche de Navidad \nes la noche de los deseos,\n les deseo que sus sueños se hagan realidad.\n ¡Saludos!",
            "Os deseo una maravillosa Navidad\n que acompañe a un mejor año nuevo\n lleno de sueños por realizar,\n el amor y la buena salud.\n ¡Feliz Navidad!",
            "Mi deseo más sincero:\n ¡Que seas feliz en esta Navidad! \nQue este año que comienza todos tus sueños\n se hagan realidad."
    };
    private String fonts[]={"Amarillo.ttf","Birds.ttf","ChopinScript.ttf","christmaseve.ttf","christmas.ttf","firstChristmas.ttf","GreatDay.ttf","HappyPappy.ttf","Hijrnotes.ttf","JennaSue.ttf","KAEMPF.TTF","KATZOFF.TTF","Kingthings.ttf","lato-italic.ttf","lato-light.ttf","lato-regular.ttf","MerryChristmasFlake.ttf","PWChristmasfont.ttf","Soulmaker.ttf","TheFabulous Orchestra.ttf"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        mContext = getApplicationContext();

        // Get the Resources
        mResources = getResources();

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mButton = (Button) findViewById(R.id.btn);
        mImageView = (ImageView) findViewById(R.id.iv);

        // Set a click listener for Button widget
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize a new Bitmap
                Bitmap bitmap = Bitmap.createBitmap(
                        700, // Width
                        700, // Height
                        Bitmap.Config.ARGB_8888
                );

                Bitmap bitmap1=BitmapFactory.decodeResource(mResources, images[mRandom.nextInt(images.length)]);
                // Initialize a new Canvas instance
                Canvas canvas = new Canvas(bitmap);

                Random g=new Random();
                // Draw a solid color on the canvas as background

                canvas.drawColor(Color.rgb(g.nextInt(255),g.nextInt(255),g.nextInt(255)));

                // Initialize a new Paint instance to draw the text
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                // Set the text color
                paint.setColor(Color.WHITE);
                paint.setAntiAlias(true);

                /*
                    public void setTextSize (float textSize)
                        Set the paint's text size. This value must be > 0

                    Parameters
                        textSize : set the paint's text size.
                */
                // Set the text size
                paint.setTextSize(35);

                /*
                    public void setTextAlign (Paint.Align align)
                        Set the paint's text alignment. This controls how the text is positioned
                        relative to its origin. LEFT align means that all of the text will be drawn
                        to the right of its origin (i.e. the origin specifieds the LEFT edge of
                        the text) and so on.

                    Parameters
                        align : set the paint's Align value for drawing text.
                */

                /*
                    Paint.Align
                        Align specifies how drawText aligns its text relative to
                        the [x,y] coordinates. The default is LEFT.

                        CENTER : The text is drawn centered horizontally on the x,y origin
                        LEFT : The text is drawn to the right of the x,y origin
                        RIGHT : The text is drawn to the left of the x,y origin
                */
                // Text alignment
                paint.setTextAlign(Paint.Align.CENTER);

                /*
                    Typeface
                        The Typeface class specifies the typeface and intrinsic style of a font.
                        This is used in the paint, along with optionally Paint settings like
                        textSize, textSkewX, textScaleX to specify how text appears when
                        drawn (and measured).
                */

                /*
                    public static Typeface create (Typeface family, int style)
                        Create a typeface object that best matches the specified existing typeface
                        and the specified Style. Use this call if you want to pick a new style from
                        the same family of an existing typeface object. If family is null,

                        this selects from the default font's family.
                    Parameters
                        family : May be null. The name of the existing type face.
                        style : The style (normal, bold, italic) of the typeface.
                            e.g. NORMAL, BOLD, ITALIC, BOLD_ITALIC
                    Returns
                        The best matching typeface.
                */

                // Initialize a typeface object to draw text on canvas
//                Typeface typeface = Typeface.create(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC);
                Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/"+fonts[mRandom.nextInt(fonts.length)]);

                // Set the paint font
                paint.setTypeface(typeface);

                // Initialize a new EmbossMaskFilter instance
                EmbossMaskFilter filter = new EmbossMaskFilter(
                        new float[]{1,5,1}, // direction of the light source
                        0.5f, // ambient light between 0 to 1
                        10, // specular highlights
                        7.5f // blur before applying lighting
                );

                // Apply the MaskFilter to draw embossed text
                paint.setMaskFilter(filter);

                // Define the text to draw on canvas
                String txt = textos[mRandom.nextInt(textos.length)];

                /*
                    public void drawText (String text, float x, float y, Paint paint)
                        Draw the text, with origin at (x,y), using the specified paint. The origin
                        is interpreted based on the Align setting in the paint.

                    Parameters
                        text : The text to be drawn
                        x : The x-coordinate of the origin of the text being drawn
                        y : The y-coordinate of the baseline of the text being drawn
                        paint : The paint used for the text (e.g. color, size, style)
                */

                // calculate the y position of canvas to draw the text
                Rect rectangle = new Rect();

                /*
                    public void getTextBounds (String text, int start, int end, Rect bounds)
                        Return in bounds (allocated by the caller) the smallest rectangle that
                        encloses all of the characters, with an implied origin at (0,0).
                    Parameters
                        text : String to measure and return its bounds
                        start : Index of the first char in the string to measure
                        end : 1 past the last char in the string measure
                        bounds : Returns the unioned bounds of all the text. Must be allocated by
                            the caller.
                */
                paint.getTextBounds(
                        txt, // text
                        0, // start
                        txt.length(), // end
                        rectangle // bounds
                );

                // Initialize a new RadialGradient object
                RadialGradient gradient = new RadialGradient(
                        mRandom.nextInt(rectangle.right),
                        mRandom.nextInt(rectangle.bottom),
                        mRandom.nextInt(rectangle.right),
                        new int[]{
                                getRandomHSVColor(),
                                getRandomHSVColor(),
                                getRandomHSVColor(),
                                getRandomHSVColor(),
                                getRandomHSVColor()
                        },
                        null, // Stops position is undefined
                        Shader.TileMode.MIRROR // Shader tiling mode
                );

                // Apply the RadialGradient as paint shader
                //paint.setShader(gradient);

                //Finally, Draw the text on the canvas at the horizontal and vertical center position
                canvas.drawBitmap(bitmap1,0,0, paint);
                int x=canvas.getWidth()/2,y=canvas.getHeight()/3 + Math.abs(rectangle.height())/2;
                for(String line:txt.split("\n")){
                    canvas.drawText(
                            line, // Text to 1
                            x,y,
                            paint // Paint
                    );
                    y+=paint.descent()-paint.ascent();
                }
                /*canvas.drawText(
                        txt, // Text to 1
                        canvas.getWidth()/2, // x
                        canvas.getHeight()/2 + Math.abs(rectangle.height())/2, // y
                        paint // Paint
                );*/

                // Display the newly created bitmap on app interface
                mImageView.setImageBitmap(bitmap);
                File file=new File(Environment.getExternalStorageDirectory()+"/out.png");
                try{
                    bitmap.compress(Bitmap.CompressFormat.PNG,100,new FileOutputStream(file));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    // Custom method to generate random HSV color
    protected int getRandomHSVColor(){
        // Generate a random hue value between 0 to 360
        int hue = mRandom.nextInt(361);

        // We make the color depth full
        float saturation = 1.0f;

        // We make a full bright color
        float value = 1.0f;

        // We avoid color transparency
        int alpha = 255;

        // Finally, generate the color
        int color = Color.HSVToColor(alpha,new float[]{hue,saturation,value});

        // Return the color
        return color;
    }
}