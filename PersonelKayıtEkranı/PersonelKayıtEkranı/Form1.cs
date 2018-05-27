using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace PersonelKayıtEkranı
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        SqlConnection baglanti = new SqlConnection("Data Source=SAV;Initial Catalog=Staff;Integrated Security=True");

        private void button1_Click(object sender, EventArgs e)
        {
            baglanti.Open();
            SqlCommand kayitekle = new SqlCommand("insert into PersonelKayit (Numara,Ad,Soyad,Departman,Pozisyon,Maaş) values (@p1,@p2,@p3,@p4,@p5,@p6)",baglanti);
            kayitekle.Parameters.AddWithValue("@p1",textBox6.Text);
            kayitekle.Parameters.AddWithValue("@p2", textBox1.Text);
            kayitekle.Parameters.AddWithValue("@p3", textBox2.Text);
            kayitekle.Parameters.AddWithValue("@p4", textBox3.Text);
            kayitekle.Parameters.AddWithValue("@p5", textBox4.Text);
            kayitekle.Parameters.AddWithValue("@p6", textBox5.Text);

            kayitekle.ExecuteNonQuery();
            baglanti.Close();

        }

        private void button2_Click(object sender, EventArgs e)
        {
            baglanti.Open();
            SqlCommand guncelle = new SqlCommand("update PersonelKayit set Numara=@k6,Ad=@k1,Soyad=@k2,Departman=@k3,Pozisyon=@k4,Maaş=@k5 where Numara=@k6",baglanti);

            guncelle.Parameters.AddWithValue("@k6", textBox6.Text);
            guncelle.Parameters.AddWithValue("@k1", textBox1.Text);
            guncelle.Parameters.AddWithValue("@k2", textBox2.Text);
            guncelle.Parameters.AddWithValue("@k3", textBox3.Text);
            guncelle.Parameters.AddWithValue("@k4", textBox4.Text);
            guncelle.Parameters.AddWithValue("@k5", textBox5.Text);

            guncelle.ExecuteNonQuery();
            baglanti.Close();

        }

        private void button3_Click(object sender, EventArgs e)
        {
            baglanti.Open();
            SqlCommand kayitsil = new SqlCommand("delete from PersonelKayit where Ad = @adi and Soyad = @soyad", baglanti);
           
            kayitsil.Parameters.AddWithValue("@adi",textBox1.Text);
            kayitsil.Parameters.AddWithValue("@soyad", textBox2.Text);
            
            kayitsil.ExecuteNonQuery();
            baglanti.Close();

        }

        private void button4_Click(object sender, EventArgs e)
        {
            SqlDataAdapter da = new SqlDataAdapter("select * from PersonelKayit where Ad ='"+textBox1.Text+"'",baglanti);
            DataSet ds = new DataSet();
            da.Fill(ds);
            dataGridView1.DataSource = ds.Tables[0];
            
        }

        private void button5_Click(object sender, EventArgs e)
        {
            SqlDataAdapter da = new SqlDataAdapter("select * from PersonelKayit",baglanti);
            DataSet ds = new DataSet();
            da.Fill(ds);
            dataGridView1.DataSource = ds.Tables[0];
        }



        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            int secilen = dataGridView1.SelectedCells[0].RowIndex;

            string no = dataGridView1.Rows[secilen].Cells[0].Value.ToString();
            string ad = dataGridView1.Rows[secilen].Cells[1].Value.ToString();
            string soyad = dataGridView1.Rows[secilen].Cells[2].Value.ToString();
            string departman = dataGridView1.Rows[secilen].Cells[3].Value.ToString();
            string pozisyon = dataGridView1.Rows[secilen].Cells[4].Value.ToString();
            string maas = dataGridView1.Rows[secilen].Cells[5].Value.ToString();

            textBox6.Text = no;
            textBox1.Text = ad;
            textBox2.Text = soyad;
            textBox3.Text = departman;
            textBox4.Text = pozisyon;
            textBox5.Text = maas;

        }

        private void button6_Click(object sender, EventArgs e)
        {
            textBox1.Clear();
            textBox2.Clear();
            textBox3.Clear();
            textBox4.Clear();
            textBox5.Clear();
            textBox6.Clear();

        }
    }
}
